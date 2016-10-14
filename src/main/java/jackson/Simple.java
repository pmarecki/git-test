package serialize;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//<!-- jackson-->

//<dependency>
//<groupId>com.fasterxml.jackson.core</groupId>
//<artifactId>jackson-core</artifactId>
//<version>${jackson.version}</version>
//</dependency>

//<dependency>
//<groupId>com.fasterxml.jackson.core</groupId>
//<artifactId>jackson-databind</artifactId>
//<version>${jackson.version}</version>


@Data
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(value = {"buu"}, ignoreUnknown = true)
class Book {
    String author;
    String title;
    Integer buu;
    BookType type;

//    @JsonIgnore
//    Integer getBuu() {
//        return buu;
//    }
}

@Data
@Builder
@AllArgsConstructor
class Order {
    String principal;
    List<Book> books;
}

enum BookType {
    Novel,
    Raport
}

@Data
public class A {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Book b = Book.builder().author("Aaaa").type(BookType.Novel).buu(12).build();
        System.out.println("Start=" + b);
        String json = mapper.writeValueAsString(b);
        System.out.println("Mapped=" + json);
        byte[] data = json.getBytes();
        String rec = new String(data);

        Book bb = mapper.readValue(rec, Book.class);
        System.out.println("End=" + bb);

        List<Book> lb = new ArrayList<>();
        lb.add(b);
        b.setTitle("Wuranga");
        lb.add(b);
        Order o = Order.builder().principal("PM").books(lb).build();

        json = mapper.writeValueAsString(o);
        System.out.println("Order(json)=" + json);
        data = json.getBytes();
        Order oo = mapper.readValue(new String(data), Order.class);
        System.out.println("Order(end)=" + oo);

    }
}

//Result

//Start=Book(author=Aaaa, title=null, buu=12, type=Novel)
//Mapped={"author":"Aaaa","title":null,"type":"Novel"}
//End=Book(author=Aaaa, title=null, buu=null, type=Novel)
//Order(json)={"principal":"PM","books":[{"author":"Aaaa","title":"Wuranga","type":"Novel"},{"author":"Aaaa","title":"Wuranga","type":"Novel"}]}
//Order(end)=Order(principal=PM, books=[Book(author=Aaaa, title=Wuranga, buu=null, type=Novel), Book(author=Aaaa, title=Wuranga, buu=null, type=Novel)])
