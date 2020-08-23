package com.retail.loyality.security;

import com.retail.loyality.security.filter.JwtRequestFilter;
import com.retail.loyality.security.util.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JwtRequestFilterTest {

    @Autowired
    JwtRequestFilter jwtRequestFilter;

    @MockBean
    private JwtTokenUtil jwtTokenUtil;

    @Ignore
    @Test
    public void loadUserByUsernameWithExpiredJwtException() throws Exception {

        doThrow(new ExpiredJwtException(Mockito.any(Header.class), Mockito.any(Claims.class), Mockito.anyString()))
                .when(jwtTokenUtil).getUsernameFromToken(Mockito.any());
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FilterChain chain = mock(FilterChain.class);
        when(request.getHeader(Mockito.any())).thenReturn("Bearer ");
        doNothing().when(chain).doFilter(request, response);
        jwtRequestFilter.doFilter(request, response, chain);
    }

    @Test
    public void loadUserByUsernameWithIllegalArgumentException() throws Exception {
        when(jwtTokenUtil.getUsernameFromToken(Mockito.anyString())).thenThrow(new IllegalArgumentException("Illegal"));
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FilterChain chain = mock(FilterChain.class);
        when(request.getHeader(Mockito.any())).thenReturn("Bearer ");
        doNothing().when(chain).doFilter(request, response);
        jwtRequestFilter.doFilter(request, response, chain);
    }
}
