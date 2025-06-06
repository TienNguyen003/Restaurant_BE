package com.project.restaurantly.Controller.user;

import com.project.restaurantly.Service.user.AuthenticationService;
import com.project.restaurantly.dto.request.token.IntrospectRequest;
import com.project.restaurantly.dto.request.token.RefreshRequest;
import com.project.restaurantly.dto.request.token.AuthenticationRequest;
import com.project.restaurantly.dto.request.token.LogoutRequest;
import com.project.restaurantly.dto.response.ApiResponse;
import com.project.restaurantly.dto.response.token.AuthenticationResponse;
import com.project.restaurantly.dto.response.token.IntrospectResponse;
import com.nimbusds.jose.JOSEException;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("${api.prefix}auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;
    SimpMessagingTemplate messagingTemplate;

    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authentication(@RequestBody @Valid AuthenticationRequest authenticationRequest){
        var result = authenticationService.authentication(authenticationRequest);
        messagingTemplate.convertAndSend("/topic/login", "tien");
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> introspect(@RequestBody @Valid IntrospectRequest introspectRequest)
            throws ParseException, JOSEException {
        var result = authenticationService.introspectResponse(introspectRequest);
        return ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/refresh")
    ApiResponse<AuthenticationResponse> authentication(@RequestBody @Valid RefreshRequest request) throws ParseException, JOSEException {
        var result = authenticationService.refreshToken(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/logout")
    ApiResponse<Void> logout(@RequestBody @Valid LogoutRequest request) throws ParseException, JOSEException {
        authenticationService.logout(request);
        return ApiResponse.<Void>builder().build();
    }
}
