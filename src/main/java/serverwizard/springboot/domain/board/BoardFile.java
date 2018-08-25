package serverwizard.springboot.domain.board;

import lombok.Getter;

import javax.persistence.*;


@Getter
@Entity
public class BoardFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_id") // 기존에 DBA가 생성한 테이블에 foreign key가 있을텐데 그 foreign key와 매핑시켜줄때 사용
    private Board board;

    // spring boot는 자동으로 mime_type으로 변경해줌???
    private String mimeType;
    private String name; // 오리지널 파일 이름
    private String saveFileName; // c://tmp/2018/08/13/uuid명
    private long size;

}
