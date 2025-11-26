package bookmanagement.view;

import bookmanagement.domain.BookVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

// 사용자에게 보여지는 view 부분을 정의.
public class BookSearchView extends JPanel {
    JTable table; // Jpanel 중 테이블 형식으로 보여주는 형태의 jtable 정의
    DefaultTableModel model; // 그 테이블 모델 중 기본 형태의 모델 사용.
    ArrayList<BookVO> bookVOList; // 책 불러와서 보여줄 arrayList
    String[] header = {"도서번호", "도서명", "출판사", "저자명", "도서가격", "카테고리명"};

    // Label, Button 등도 클래스에 넣어둘 수 있다.
    JLabel lbl;
    JTextField textSearch;
    JButton btnSearch;

    String searchWord = "";
    JPanel panN;
    JComboBox<String> combo;
    String[] comboStr = {"도서명", "출판사", "저자명"};

    public BookSearchView(){
        //JPanel은 기본 flow 레이아웃인데, 원하는대로 요소를 배치하기 위해 Border 레이아웃으로 변경
        setLayout(new BorderLayout());
        combo = new JComboBox(comboStr);
        lbl = new JLabel("검색어");
        textSearch = new JTextField(20);
        btnSearch = new JButton("검색");

        panN = new JPanel();
        panN.add(combo);
        panN.add(lbl);
        panN.add(textSearch);
        panN.add(btnSearch);
    }

    //JTable과 DefaultTable을 연결하고 테이블과 관련된 내용들을 초기화
    public void initView(){
        // header(컬럼명), 행? 이렇게 선언하는건데, 행은 책의 개수만큼 생성되어야 하므로 bookVOList.size를 사용한 것
        model = new DefaultTableModel(header, bookVOList.size()){
            @Override
            public boolean isCellEditable(int row, int column){
                // DefaultTableModel은 기본적으로 화면 상에서 편집이 가능하다.(isEditable=True)
                // 그걸 비활성화 하기 위해 false;
                return false;
            }
        };

        table = new JTable(model);
        // 테이블의 컬럼 너비
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);
        table.getColumnModel().getColumn(5).setPreferredWidth(70);

        // 테이블의 행의 개수가 많을 때는 스크롤바가 필요
        JScrollPane scrollPane = new JScrollPane(table);
        
        // 각 셀에 리스트에 저장된 BookVO 객체가 가지고 있는 값들을 설정
        putSearchResult();
        
        // 현재 패널에 North에는 panN, Center에는 스크롤바가 있는 테이블
        add(panN, BorderLayout.NORTH); //North
        add(scrollPane, BorderLayout.CENTER);
    }

    // DefaultTable에 도서 정보들을 설정한다.
    public void putSearchResult() {
        // model에 행 개수 설정
        model.setRowCount(bookVOList.size());
        BookVO vo = null;
        for(int i=0; i<bookVOList.size(); i++){
            vo = bookVOList.get(i);
            model.setValueAt(vo.getIsbn(), i, 0);
            model.setValueAt(vo.getName(), i, 1);
            model.setValueAt(vo.getPublish(), i, 2);
            model.setValueAt(vo.getAuthor(), i, 3);
            model.setValueAt(vo.getPrice(), i, 4);
            model.setValueAt(vo.getCategoryName(), i, 5);

        }
    }

    public String getSearchWord(){
        searchWord = textSearch.getText();
        return searchWord;
    }
    public void setBookVOList(ArrayList<BookVO> bookVOList){
        this.bookVOList = bookVOList;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JComboBox<String> getCombo() {
        return combo;
    }
}
