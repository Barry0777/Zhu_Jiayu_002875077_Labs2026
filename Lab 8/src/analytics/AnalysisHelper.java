package analytics;

import data.DataStore;
import java.util.*;
import model.Comment;
import model.Post;
import model.User;

public class AnalysisHelper {

    /* ---------------- Q1 ---------------- */
    public void getAverageLikesPerComments() {
        Collection<Comment> comments = DataStore.getInstance().getComments().values();

        int sumLikes = 0;
        for (Comment c : comments) {
            sumLikes += c.getLikes();
        }

        double avg = comments.isEmpty() ? 0 : (double) sumLikes / comments.size();
        System.out.println("Q1 - Average likes per comment: " + (int) avg);
    }
    

    /* ---------------- Q2 ---------------- */
    public void getMaxLikeCommentPost() {
        DataStore ds = DataStore.getInstance();
        Comment best = null;

        for (Comment c : ds.getComments().values()) {
            if (best == null || c.getLikes() > best.getLikes()) {
                best = c;
            }
        }

        if (best != null) {
            System.out.println("Q2 - Post with most-liked comment: " + best.getPostId());
        }
    }

    /* ---------------- Q3 ---------------- */
    public void getPostwithMostcomments() {
        DataStore ds = DataStore.getInstance();
        Post maxPost = null;

        for (Post p : ds.getPosts().values()) {
            if (maxPost == null || p.getComments().size() > maxPost.getComments().size()) {
                maxPost = p;
            }
        }

        if (maxPost != null) {
            System.out.println("Q3 - Post with most comments: " + maxPost.getPostId());
        }
    }

    /* 工具函数：依照统计值排序用户（升序） */
    private List<User> sortedUsersBy(Map<Integer, Integer> map) {
        List<User> users = new ArrayList<>(DataStore.getInstance().getUsers().values());

        users.sort((a, b) -> {
            int x = map.getOrDefault(a.getId(), 0);
            int y = map.getOrDefault(b.getId(), 0);
            return Integer.compare(x, y);
        });

        return users;
    }

    /* ---------------- Q4 ---------------- */
    public void getPassiveUsers() {
        Map<Integer, Integer> count = new HashMap<>();
        DataStore ds = DataStore.getInstance();

        for (Post p : ds.getPosts().values()) {
            int uid = p.getUserId();
            count.put(uid, count.getOrDefault(uid, 0) + 1);
        }

        List<User> result = sortedUsersBy(count);

        System.out.println("Q4 - Users with least posts:");
        for (int i = 0; i < Math.min(5, result.size()); i++) {
            User u = result.get(i);
            System.out.println(u + " - posts: " + count.getOrDefault(u.getId(), 0));
        }
    }

    /* ---------------- Q5 ---------------- */
    public void getPassiveCommentUsers() {
        Map<Integer, Integer> count = new HashMap<>();
        DataStore ds = DataStore.getInstance();

        for (Comment c : ds.getComments().values()) {
            int uid = c.getUserId();
            count.put(uid, count.getOrDefault(uid, 0) + 1);
        }

        List<User> sorted = sortedUsersBy(count);

        System.out.println("Q5 - Users with least comments:");
        for (int i = 0; i < Math.min(5, sorted.size()); i++) {
            User u = sorted.get(i);
            System.out.println(u + " - comments: " + count.getOrDefault(u.getId(), 0));
        }
    }

    /* ---------------- Q6 + Q7 ---------------- */
    public void getPassiveAndActiveoverallUsers() {

        Map<Integer, Integer> score = new HashMap<>();
        DataStore ds = DataStore.getInstance();

        /* comments contribute = 1 per comment + likes */
        for (Comment c : ds.getComments().values()) {
            int uid = c.getUserId();
            score.put(uid, score.getOrDefault(uid, 0) + 1 + c.getLikes());
        }

        /* posts contribute = 1 each */
        for (Post p : ds.getPosts().values()) {
            int uid = p.getUserId();
            score.put(uid, score.getOrDefault(uid, 0) + 1);
        }

        List<User> sorted = sortedUsersBy(score);

        System.out.println("Q6 - Least active users:");
        for (int i = 0; i < Math.min(5, sorted.size()); i++) {
            User u = sorted.get(i);
            System.out.println(u + " - overall: " + score.get(u.getId()));
        }

        System.out.println("Q7 - Most active users:");
        for (int i = sorted.size() - 1; i >= Math.max(sorted.size() - 5, 0); i--) {
            User u = sorted.get(i);
            System.out.println(u + " - overall: " + score.get(u.getId()));
        }
    }
}
