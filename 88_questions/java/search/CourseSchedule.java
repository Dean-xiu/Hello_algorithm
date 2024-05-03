package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/course-schedule/description/">course-schedule</a>
 */
public class CourseSchedule {
    /**
     * BFS_graph
     * TC: O(m+n)  n is the number of node, m is the number of edge
     * SC: O(m+n)  adjacency list stores the node and edge
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish_BFS(int numCourses, int[][] prerequisites) {
        //in-degree table stores the in-degree of each node of the graph
        int[] indegree = new int[numCourses];
        //adjacency list stores the adjacent nodes of each node of the graph
        List<List<Integer>> adjacency = new ArrayList<>();
        //queue stores the node which in-degree is zero
        Queue<Integer> queue = new LinkedList<>();

        //initial adjacency list
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        //store adjacent node and in-degree of each node
        for (int[] edge : prerequisites) {
            indegree[edge[0]]++;
            adjacency.get(edge[1]).add(edge[0]);
        }

        //put all node with in-degree zero into queue
        for (int i=0;i<indegree.length;i++) {
            if(indegree[i]==0) queue.offer(i);
        }

        //BFS
        while (!queue.isEmpty()) {
            Integer pre = queue.poll();
            numCourses--;
            //reduce the in-degree of adjacent node of pre node
            for (int cur:adjacency.get(pre)) {
                if(--indegree[cur]==0) queue.offer(cur);
            }
        }
        return numCourses == 0;
    }

    /**
     * DFS_graph
     *TC: O(n+m)  n is the number of node, m is the number of edge
     *SC: O(n+m)  adjacency stores the edge of each node
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish_DFS(int numCourses, int[][] prerequisites) {
        //adjacency list stores the adjacent node of each node
        List<List<Integer>> adjacency = new ArrayList<>();
        //stores whether current node is visited
        int[] flags = new int[numCourses];

        //initial adjacency list
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        //stores adjacent node of each node
        for (int[] edge : prerequisites) {
            adjacency.get(edge[1]).add(edge[0]);
        }

        //dfs for each node to judge whether there is a ring
        for (int i = 0; i < numCourses; i++) {
            //if there's no ring, dfs return true, else return false
            if(!dfs(adjacency,flags,i)) return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        //current node is visited twice in current dfs,means there is a ring
        if(flags[i]==1) return false;
        //current node is visited by other node, don't need visited repeatedly
        if(flags[i]==-1) return true;

        flags[i] = 1;
        for (int node : adjacency.get(i)) {
            if(!dfs(adjacency,flags,node)) return false;
        }
        //-1 means current node in current dfs finished, the node has been visited
        flags[i] = -1;
        return true;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{0, 1}};
        System.out.println(canFinish_BFS(2, prerequisites));
    }
}
