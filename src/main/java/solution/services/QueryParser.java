package solution.services;

import solution.model.Query;

public interface QueryParser {
    Query parseQuery(String line);
}
