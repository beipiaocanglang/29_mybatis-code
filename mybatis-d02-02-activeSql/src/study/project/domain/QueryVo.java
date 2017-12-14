package study.project.domain;

import java.util.List;

/**
 * Created by canglang on 2017/12/10.
 */
public class QueryVo {
    //模拟参数较多的情况传值
    private User user;

    //foreach玄幻标签时使用的
    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
