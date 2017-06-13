package com.claurier.securitybasic.modules.security.controller;

/**
 * Created by CARL on 09/06/2017.
 */
import com.claurier.securitybasic.modules.security.JwtTokenUtil;
import com.claurier.securitybasic.modules.security.service.JwtProperties;
import com.claurier.user.modules.user.IJwtUser;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConditionalOnMissingBean(value={com.claurier.securitybasic.modules.security.controller.IAuthRestController.class})
@RequestMapping(value={"auth"})
public class AuthenticationRestController {
    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value={"login"}, method={RequestMethod.POST})
    public ResponseEntity<?> createAuthenticationToken(@RequestBody com.claurier.securitybasic.modules.security.controller.JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {
        Authentication authentication = this.authenticationManager.authenticate((Authentication)new UsernamePasswordAuthenticationToken((Object)authenticationRequest.getUsername(), (Object)authenticationRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        String token = this.jwtTokenUtil.generateToken(userDetails, authenticationRequest.isRememberMe());
        return ResponseEntity.ok((Object)new JwtAuthenticationResponse(token));
    }

    @RequestMapping(value={"user"}, method={RequestMethod.GET})
    public IJwtUser getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(this.jwtProperties.getHeader());
        String username = this.jwtTokenUtil.getUsernameFromToken(token);
        return (IJwtUser)this.userDetailsService.loadUserByUsername(username);
    }

    @RequestMapping(value={"refresh"}, method={RequestMethod.GET})
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(this.jwtProperties.getHeader());
        String username = this.jwtTokenUtil.getUsernameFromToken(token);
        IJwtUser user = (IJwtUser)this.userDetailsService.loadUserByUsername(username);
        if (this.jwtTokenUtil.canTokenBeRefreshed(token).booleanValue()) {
            String refreshedToken = this.jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok((Object)new JwtAuthenticationResponse(refreshedToken));
        }
        return ResponseEntity.badRequest().body((Object)null);
    }
}

