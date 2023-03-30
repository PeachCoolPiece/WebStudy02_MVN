package kr.or.ddit.file;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface MultipartFile {
     public byte[] getBytes() throws IOException; //
     public String  getContentType(); // mine 타입을 확인 해서 이미지 파일이 아니면 돌려보냄
     public InputStream getInputStream() throws IOException ;
     public String getName(); // 인풋 태그의 name 속성 값을 리턴
     public String getOriginalFilename();
     public long getSize(); // 파일의 사이즈
    public boolean isEmpty(); // 파일이 비어 있는지 아닌지 확인
    public void transferTo(File saveFile)throws IOException; // 파일을 전송

}
