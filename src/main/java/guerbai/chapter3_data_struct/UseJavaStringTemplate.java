package guerbai.chapter3_data_struct;

import org.apache.commons.text.StringSubstitutor;

import java.util.HashMap;
import java.util.Map;

import static guerbai.util.Print.print;
import static java.lang.System.currentTimeMillis;

public class UseJavaStringTemplate {

    public static void main(String[] args) {
        long startAt = currentTimeMillis();

        Map<String, String> valuesMap = new HashMap<String, String>();
        valuesMap.put("animal", "quick brown fox");
        valuesMap.put("target", "lazy dog");
        String templateString = "The ${animal} jumped over the ${target}.";
        StringSubstitutor sub = new StringSubstitutor(valuesMap);
        String resolvedString = sub.replace(templateString);
        print(resolvedString);

        long endAt = currentTimeMillis();
        print("Program cost time: " + (float) (endAt - startAt) / 1000 + 's');
    }
}
