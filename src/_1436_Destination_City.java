import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.
 * <p>
 * It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * Output: "Sao Paulo"
 * Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
 * Example 2:
 * <p>
 * Input: paths = [["B","C"],["D","B"],["C","A"]]
 * Output: "A"
 * Explanation: All possible trips are: 
 * "D" -> "B" -> "C" -> "A". 
 * "B" -> "C" -> "A". 
 * "C" -> "A". 
 * "A". 
 * Clearly the destination city is "A".
 * Example 3:
 * <p>
 * Input: paths = [["A","Z"]]
 * Output: "Z"
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= paths.length <= 100
 * paths[i].length == 2
 * 1 <= cityAi.length, cityBi.length <= 10
 * cityAi != cityBi
 * All strings consist of lowercase and uppercase English letters and the space character.
 */

public class _1436_Destination_City {
    public String destCity(List<List<String>> paths) {
        // hashMap. The outdegree
        Map<String, Integer> map = new HashMap<>();

        for (List<String> path : paths) {
            String src = path.get(0);
            String des = path.get(1);

            map.put(src, map.getOrDefault(src, 0) + 1);
            map.put(des, map.getOrDefault(des, 0));
        }

        for (String key : map.keySet()) {
            if (map.get(key) == 0) {
                return key;
            }
        }

        return "";
    }
}
