package serverwizard.springboot.domain.board;

import lombok.Getter;
import serverwizard.springboot.domain.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FetchType.EAGER 사용할때 주의할점은 순환참조(무한 루프)를 조심해야한다.
    // A->B->C->A
    // FetchType.LAZY의 단점은 N+1문제가 일어날수있다 (해결: fetch join)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id") //  기존에 DBA가 생성한 테이블에 foreign key가 있을텐데 그 foreign key와 매핑시켜줄때 사용
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_category_id")
    private BoardCategory boardCategory;

    // 게시판 파일 목록, Cascade : 영속성 전파 (같이 영속성 부여하겠다)
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<BoardFile> boardFiles;

    private String title;
    private String content;

    private int readCount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}
