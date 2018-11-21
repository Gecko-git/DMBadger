/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmbadger;

import java.util.ArrayList;
import java.util.List;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;

/**
 *
 * @author gecko
 */
public class TestJena {

    protected String inputWord;

    TestJena(String inputWord) {
        this.inputWord = inputWord;
    }

    public String main() {
        // クエリを投げるSPARQLエンドポイント
        String service = "http://ja.dbpedia.org/sparql";

        // SPARQLクエリ
        String queryString = "PREFIX dbpj: <http://ja.dbpedia.org/resource/>\n"
                + "PREFIX dbp-owl: <http://dbpedia.org/ontology/>\n"
                + "PREFIX prop:<http://ja.dbpedia.org/property/>"
                + "SELECT ?birth_date\n"
                + "WHERE\n"
                + "{\n"
                + " dbpj:";

        queryString += inputWord;
        queryString += " dbp-owl:birthDate ?birth_date.}";

        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.sparqlService(service, query);
        ResultSet results = qexec.execSelect();
        List test = ResultSetFormatter.toList(results);
        //String resultString = ResultSetFormatter.asText(results); //文字列での取得

        System.out.println(test.size());
        String resultString;
        
        if (test.size() != 0) {
            resultString = test.get(0).toString().substring(test.get(0).toString().indexOf("\""), test.get(0).toString().indexOf("^^"));
        } else {
            resultString = "結果なし";
        }
        //ResultSetFormatter.out(System.out, results, query);
        qexec.close();
        return resultString;
    }
}
