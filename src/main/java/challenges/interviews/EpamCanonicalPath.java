package challenges.interviews;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * # Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
 * <p>
 * # In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
 * <p>
 * # The canonical path should have the following format:
 * <p>
 * # The path starts with a single slash '/'.
 * # Any two directories are separated by a single slash '/'.
 * # The path does not end with a trailing '/'.
 * # The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
 * # Return the simplified canonical path.
 * <p>
 * <p>
 * <p>
 * # Example 1:
 * # Input: path = "/home/"
 * # Output: "/home"
 * # Explanation: Note that there is no trailing slash after the last directory name.
 * <p>
 * # Example 2:
 * # Input: path = "/../"
 * # Output: "/"
 * # Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 * <p>
 * # Example 3:
 * # Input: path = "/home//foo/"
 * # Output: "/home/foo"
 * # Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 * <p>
 * # Example 4:
 * # Input: path = "/a/./b/../../../c/"
 * /a/./b  -> /a/b
 * # Output: "/c"
 * <p>
 * /c
 * <p>
 * a period '.' refers to the current directory
 */
public class EpamCanonicalPath {

    public static void main(String[] args) {
        System.out.println(getCanonicalPath("/../"));
    }
    //"/",""
    public static String getCanonicalPath(String unixPath) {
        List<String> elementsPath = new LinkedList<>();

        String[] splitPath = unixPath.split("/");
        for (int i = 0; i < splitPath.length; i++) {
            if (splitPath[i].equals(".")) {
                continue;
            } else if (splitPath[i].equals("..")) {
                if(!elementsPath.isEmpty()) {
                    elementsPath.remove(elementsPath.size() - 1);
                }
            } else if (splitPath[i].isEmpty()) {
                continue;
            } else {
                elementsPath.add(splitPath[i]);
            }

        }

        return elementsPath.isEmpty() ? "/" :
                elementsPath.stream().collect(Collectors.joining("/","/",""));
    }
}
