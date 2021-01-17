package WebLayer;

import PersistenceLayer.User.UserInterface;

import javax.annotation.Priority;
import javax.ejb.EJB;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@NeededLogin
@Priority(Priorities.AUTHENTICATION)
@Provider
public class NeededLoginAnalyzer implements ContainerRequestFilter {
    @EJB
    UserInterface userToken;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new NotAuthorizedException("Не указан заголовок аутентификации");
        }
        String token = authorizationHeader.substring("Bearer ".length()).trim();

        if (userToken.find(token) == null) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }
}