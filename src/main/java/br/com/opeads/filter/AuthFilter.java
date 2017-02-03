package br.com.opeads.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthFilter extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		String header = request.getHeader("Authorization");
		
		if(header == null || !header.startsWith("Bearer ")){
				throw new ServletException("Token inexistente ou inválido!");
		}
		
		String token = header.substring(7);
		Claims claim = null;
		try{
			claim = Jwts.parser().setSigningKey("wansan").parseClaimsJws(token).getBody();
		}catch(Exception e){
			((HttpServletResponse)res).sendError(HttpServletResponse.SC_UNAUTHORIZED,"Token Inválido");
		}
		
		HttpServletResponse response = (HttpServletResponse)res;
		response.setHeader("Authorization", "Bearer " + Jwts.builder().setSubject(claim.getSubject()).signWith(SignatureAlgorithm.HS512, "wansan").setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000)).compact());
		res = (ServletResponse) response;
		chain.doFilter(req, res);
			
	}

}
