package y2022.sep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/find-duplicate-file-in-system/
public class Solution0919 {

    public List<List<String>> findDuplicate(String[] paths) {
        /*
        "root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"
        [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
         */

        /*
         fileContent : list
         */
        Map<String, List<String>> fileContentPathListMap = new HashMap<>();


        for (String path : paths) {
            String[] split = path.split(" ");
            String filePath = split[0]; // root/a
            for (int i = 1; i < split.length; i++) {
                String file = split[i];  // 1.txt(abcd)
                Integer contentIndex = file.indexOf("(");
                String fileName = file.substring(0, contentIndex);
                String fileContent = file.substring(contentIndex + 1, file.length() - 1);

                if (!fileContentPathListMap.containsKey(fileContent)) {
                    fileContentPathListMap.put(fileContent, new ArrayList<>());
                }
                fileContentPathListMap.get(fileContent).add(filePath + "/" + fileName);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> stringListEntry : fileContentPathListMap.entrySet()) {
            if (stringListEntry.getValue().size() > 1) {
                ans.add(stringListEntry.getValue());
            }
        }

        return ans;


        /*
        진짜 파일 시스템이면 어떻게 풀까?
          /a/1.txt
            /2.txt
          /b/3.txt
          /c/4.txt
          directory[] -> file[] -> map ->
        컨텐츠가 GB 단위면 어떻게 풀까?

        만약에 한번에 1kb 씩 읽는 다면 어떻게 풀까? -> 느리게 읽어 온다면 성능관점
         -> 1kb 중복이 아닌건 금방 찾는데 중복인건 증명할려면 다 읽어야 되요
         -> 파일의 마지막만 다르다면 모든 파일을 다 읽어야 되서 최악의 성능이 나오게 되는데
            -> 이건 어쩔 수 없다.

        map key로 사용 가능?
        GB -> hash 처리를 해서 줄여야 되는데 -> 줄였을떄 정말로 중복인지 보려면 결국 다 읽어야 한다.


        Follow up questions:

        1. Imagine you are given a real file system, how will you search files? DFS or BFS ?
        In general, BFS will use more memory then DFS. However BFS can take advantage of the locality of files in inside directories, and therefore will probably be faster

        2. If the file content is very large (GB level), how will you modify your solution?
        In a real life solution we will not hash the entire file content, since it's not practical. Instead we will first map all the files according to size. Files with different sizes are guaranteed to be different. We will than hash a small part of the files with equal sizes (using MD5 for example). Only if the md5 is the same, we will compare the files byte by byte

        3. If you can only read the file by 1kb each time, how will you modify your solution?
        This won't change the solution. We can create the hash from the 1kb chunks, and then read the entire file if a full byte by byte comparison is required.

        What is the time complexity of your modified solution? What is the most time consuming part and memory consuming part of it? How to optimize?
        Time complexity is O(n^2 * k) since in worse case we might need to compare every file to all others. k is the file size

        How to make sure the duplicated files you find are not false positive?
        We will use several filters to compare: File size, Hash and byte by byte comparisons.
         */
    }

    public static void main(String[] args) throws Exception {
        Solution0919 s = new Solution0919();

        //["root/a 1.txt(abcd) 2.txt(efsfgh)","root/c 3.txt(abdfcd)","root/c/d 4.txt(efggdfh)"]
        System.out.println(s.findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"}));
    }

}
