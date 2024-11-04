package com.example.coursemanagementsystem.config;

import io.jsonwebtoken.Claims; // Claims interface for JWT claims
import io.jsonwebtoken.Jwts; // Main class for creating and parsing JWTs
import io.jsonwebtoken.SignatureAlgorithm; // Enum for signature algorithms
import io.jsonwebtoken.io.Decoders; // Utility for decoding Base64
import io.jsonwebtoken.security.Keys; // Utility for generating security keys
import org.springframework.security.core.userdetails.User; // User details for authentication
import org.springframework.security.core.userdetails.UserDetails; // Interface for user details
import org.springframework.stereotype.Service; // Indicates that this class is a service component

import java.security.Key; // Represents a cryptographic key
import java.util.Date; // Represents date and time
import java.util.HashMap; // HashMap for storing additional claims
import java.util.Map; // Map interface for key-value pairs
import java.util.function.Function; // Functional interface for lambda expressions

@Service // Marks this class as a Spring service
public class JwtService {

    // Secret key used for signing the JWT
    private static final String SECRET_KEY = "9af74e5f1f7a8f7431b12a2f203490d5775b034fea899ab170062940ab9fad2d";

    // Extracts the username (subject) from the JWT token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Generates a JWT token for the given user details
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails); // Calls overloaded method with empty claims
    }

    // Generates a JWT token with additional claims
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(extraClaims) // Sets additional claims
                .setSubject(userDetails.getUsername()) // Sets the subject (username)
                .setIssuedAt(new Date(System.currentTimeMillis())) // Sets the issue date
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)) // Sets expiration time (24 minutes)
                .signWith(getSignInKey(), SignatureAlgorithm.HS256) // Signs the token with the signing key and algorithm
                .compact(); // Builds the JWT token
    }

    // Validates the JWT token against the user details
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token); // Extracts the username from the token
        // Checks if the username matches and the token is not expired
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    // Checks if the token has expired
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date()); // Compares expiration date with current date
    }

    // Extracts the expiration date from the token
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration); // Retrieves expiration claim
    }

    // Extracts a specific claim from the token using a resolver function
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractallClaims(token); // Extracts all claims
        return claimsResolver.apply(claims); // Applies the resolver to the claims
    }

    // Extracts all claims from the token
    private Claims extractallClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey()) // Sets the signing key for parsing
                .build()
                .parseClaimsJws(token) // Parses the JWT
                .getBody(); // Retrieves the claims body
    }

    // Generates a signing key from the secret key
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY); // Decodes the Base64-encoded secret key
        return Keys.hmacShaKeyFor(keyBytes); // Returns a key for HMAC SHA
    }
}