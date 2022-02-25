//package com.example.board.service;
//
//import com.example.board.domain.Diary;
//import com.example.board.dto.CalenderDay;
//import com.example.board.repository.ArticleRepository;
//import java.util.List;
//import org.hibernate.engine.jdbc.connections.spi.DataSourceBasedMultiTenantConnectionProviderImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//@SpringBootTest
//public class DiaryServiceTest {
//    @Autowired
//    DiaryService diaryService;
//
//    public void getCalenderTest(){
//        List<Diary> thisMonthDiaries = diaryService.getThisMonthDiary();
//        List<List<CalenderDay>> calender = diaryService.getThisMonthCalender(thisMonthDiaries);
//        for(int i=0; i<calender.size(); i++){
//            for(int j=0; j<calender.get(0).size(); j++){
//                System.out.println(calender.get(i).get(j));
//            }
//        }
//    }
//}
