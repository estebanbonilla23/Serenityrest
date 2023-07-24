package Models.Queries;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class Post {
    private Integer userId;
    private String title;
    private String body;
}