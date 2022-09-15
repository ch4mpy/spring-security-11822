# spring-security-11822

`JwtAuthenticationProvider` should not aggressively set authentication details.

## reproduce
- edit application.properties to point to your favorite authorization-server
- get a JWT access-token
- edit token value `SpringSecurity11822ApplicationTests`
- run `SpringSecurity11822ApplicationTests`