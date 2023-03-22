package membership;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.JDBConnect;
import membership.MemberDTO;



public class MemberDAO extends JDBConnect {
	public MemberDAO() {
		super();
	}
    // 명시한 데이터베이스로의 연결이 완료된 MemberDAO 객체를 생성합니다.
    public MemberDAO(String drv, String url, String id, String pw) {
        super(drv, url, id, pw);
    }

    // 명시한 아이디/패스워드와 일치하는 회원 정보를 반환합니다.
    public MemberDTO getMemberDTO(String uid) {
        MemberDTO dto = new MemberDTO();  // 회원 정보 DTO 객체 생성
        String query = "SELECT * FROM member WHERE id=? ";  // 쿼리문 템플릿

        try {
            // 쿼리 실행
            psmt = con.prepareStatement(query); // 동적 쿼리문 준비
            psmt.setString(1, uid);    // 쿼리문의 첫 번째 인파라미터에 값 설정
            rs = psmt.executeQuery();  // 쿼리문 실행

            // 결과 처리
            if (rs.next()) {
                // 쿼리 결과로 얻은 회원 정보를 DTO 객체에 저장
                //dto.setId(rs.getString("id"));
                //dto.setPass(rs.getString("pass"));
                //dto.setName(rs.getString(3));
                //dto.setRegidate(rs.getString(4));
            	String id = rs.getString("id");
            	String pass = rs.getString("pass");
            	String name = rs.getString("name");
            	String regidate = rs.getString("regidate");
            	String tel = "";
            	String email = "";
            	dto = new MemberDTO(id, pass, name, tel, email, regidate);
            	
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return dto;  // DTO 객체 반환
    }


    public int selectCount() {
		int totalCount = 0;	
		String sql = "SELECT count(id) as cnt FROM MEMBER ";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {				
				totalCount = rs.getInt(1);
				//totalCount = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return totalCount;		
	}    
   

	public List<MemberDTO> selectList() { // 게시물 목록(검색 포함)
		List<MemberDTO> bbs = new ArrayList<MemberDTO>();	
		String sql = "SELECT * FROM MEMBER ";
		
		System.out.println(sql);
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {				
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setEmail(rs.getString("email"));
				dto.setRegidate(rs.getString("regidate"));
				bbs.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bbs;		
	}

	public int insertWrite(MemberDTO dto) {
		int totalCount = 0;	
		String sql = "insert into member(id,pass,name,tel,email) ";
		sql+= "	values (?,?,?,?,?)";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getTel());
			psmt.setString(5, dto.getEmail());
			totalCount = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return totalCount;		
	}


	public MemberDTO selectView(String  id) { // 게시물 1개
		MemberDTO dto  = new MemberDTO();	
		String sql = "SELECT * FROM MEMBER m WHERE id = ?";
			   
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setEmail(rs.getString("email"));
				dto.setRegidate(rs.getString("regidate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;		
	}	

	public int updateEdit(MemberDTO dto) {
		System.out.println(dto);
		int totalCount = 0;	
		String sql = "update member set pass=?, tel=?, email=? where id=? ";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getPass());
			psmt.setString(2, dto.getTel());
			psmt.setString(3, dto.getEmail());
			psmt.setString(4, dto.getId());
			totalCount = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return totalCount;		
	}
	
	public int deletePost(String id) {
		int result = 0;
		String sql = "DELETE FROM MEMBER WHERE id = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);			
			result = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<MemberDTO> selectListPage(Map<String, Object> map) { // 게시물 목록
		List<MemberDTO> bbs = new ArrayList<MemberDTO>();	
		String sql = "select * from("
				+"select tb.*, rownum rNum from "
				+" (select * from member b ) tb ) "
				+" where rnum BETWEEN ? and ? ";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, (int)map.get("start"));
			psmt.setInt(2, (int)map.get("end"));
			rs = psmt.executeQuery();
			while(rs.next()) {				
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				dto.setRegidate(rs.getString("regidate"));
				dto.setEmail(rs.getString("email"));
				dto.setTel(rs.getString("tel"));
				bbs.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bbs;		
	}


}