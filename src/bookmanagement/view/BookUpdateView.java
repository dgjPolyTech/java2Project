package bookmanagement.view;

import bookmanagement.domain.BookVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class BookUpdateView extends JPanel {
    JTable table; // Jpanel 중 테이블 형식으로 보여주는 형태의 jtable 정의
    DefaultTableModel model; // 그 테이블 모델 중 기본 형태의 모델 사용.
    ArrayList<BookVO> bookVOList; // 책 불러와서 보여줄 arrayList
    String[] header = {"도서번호", "도서명", "출판사", "저자명", "도서가격", "카테고리명"};
    String[] categoryNames = {"IT도서", "소설", "비소설", "경제", "사회"}; // 카테고리 입력 시 사용할 카테고리들.

    JPanel panS;
    JLabel[] lbls = new JLabel[header.length];
    JTextField[] tf = new JTextField[header.length -1]; // 카테고리는 콤보박스로 넣을 거라 textField가 필요없다.
    JComboBox<String> categoryCombo;
    JButton btnUpdate;

    public BookUpdateView(){
        setLayout(new BorderLayout());

        categoryCombo = new JComboBox<>(categoryNames);
        btnUpdate = new JButton("도서수정");
        panS = new JPanel(new GridLayout(4, 4)); //

        // 위에서 선언한 객체들을 화면에 추가하는 과정.
        for(int i =0; i< header.length; i++) {
            lbls[i] = new JLabel(header[i]);
            panS.add(lbls[i]);

            if(i < header.length -1) {
                tf[i] = new JTextField();
                panS.add(tf[i]);
            } else {
                panS.add(categoryCombo);
            }
        }

        tf[0].setEditable(false);

        // 버튼을 적당히 띄어서 배치하기 위해, 의미없는 빈 라벨을 추가하는 것
        for(int i=0; i<3; i++){
            panS.add(new JLabel(" "));
        }
        panS.add(btnUpdate);
    }
    
    // table에서 선택한 행의 셀 값들이 텍스트 필드에 설정되게
    public void setTextField(int rowIndex) {
        for(int i=0; i<tf.length; i++) {
            tf[i].setText(model.getValueAt(rowIndex, i).toString());
        }

        categoryCombo.setSelectedItem((String)model.getValueAt(rowIndex, 5));
    }

    //JTable과 DefaultTable을 연결하고 테이블과 관련된 내용들을 초기화
    public void initView(){
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
        
        // 현재 패널의 center에는 스크롤바 있는 테이블, south에는 도서추가 패널
        add(scrollPane, BorderLayout.CENTER);
        add(panS, BorderLayout.SOUTH);
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

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBookVOList(ArrayList<BookVO> bookVOList){
        this.bookVOList = bookVOList;
    }

    public BookVO neededUpdateData() {
        BookVO vo = new BookVO();
        vo.setIsbn(Integer.parseInt(tf[0].getText()));
        vo.setName(tf[1].getText());
        vo.setPublish(tf[2].getText());
        vo.setAuthor(tf[3].getText());
        vo.setPrice(Integer.parseInt(tf[4].getText()));
        vo.setCategoryName((String) categoryCombo.getSelectedItem());

        return vo;
    }

    public void initUpdateData(){
        for(int i=0; i < tf.length; i++) {
            tf[i].setText("");
        }
        categoryCombo.setSelectedIndex(0);
    }

    public JTable getTable() {
        return table;
    }
}
