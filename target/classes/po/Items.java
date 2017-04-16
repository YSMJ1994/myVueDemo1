package po;

import org.springframework.stereotype.Component;

/**
 * 创建自: Sober 时间: 2016/12/2.
 */
@Component
public class Items {
    private int id;
    private String item_name;
    private String description;
    private int price;

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
