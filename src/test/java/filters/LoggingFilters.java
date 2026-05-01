package filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingFilters implements Filter {

    Logger logger = LogManager.getLogger(LoggingFilters.class);

    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {
        logRequest(requestSpec);
        Response response = ctx.next(requestSpec, responseSpec);
        logResponse(response);
        return response;
    }

    public void logRequest(FilterableRequestSpecification requestSpec) {
        logger.info("BaseUri=" + requestSpec.getBaseUri());
        logger.info("Request header" + requestSpec.getHeaders());
        logger.info("Request body" + requestSpec.getBody());
    }

    public void logResponse(Response response) {
        logger.info("Response body" + response.getStatusCode());
        logger.info("Response body" + response.getCookies());
        logger.info("Response body" + response.getHeaders());
        logger.info("Response body" + response.getBody().prettyPrint());
    }
}