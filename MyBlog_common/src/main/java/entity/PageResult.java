package entity;

//分页结果类
import java.util.List;

public class PageResult <T> {
    private  long total;//总页数
    private List<T> rows;//内容

    public PageResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult() {
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
