package org.gb.demostream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoStreamApplication.class, args);

		// su dung class implement
		Greeting vietnam = new VietNam();
		vietnam.greet("Xin chao Hoang");

		//su dung Anonymous class
		Greeting english = new Greeting() {
			@Override
			public void greet(String name) {
				System.out.println("Hello " + name);
			}
		};
		english.greet("Hello Hoang");

		//su dung lambda
		Greeting french = (name) -> System.out.println("Bonjour " + name);
		french.greet("Bonjour Hoang");

		Greeting japanese = (name) -> System.out.println("こんにちは " + name);
		japanese.greet("こんにちは Hoang");

		//su dung lambda voi 2 tham so
		Calculator add = (a, b) -> a + b;
		System.out.println("Tong 2 so la: " + add.calculate(5, 3));


		//su dung stream
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Stream<Integer> stream = list.stream();
		//in ra cac so le nhan 2 tinh tong cac so
		int sum = list.stream()
				.filter(e -> e % 2 != 0)
				.map(e -> e * 2)
				.reduce(0, (a, b) -> a + b);
		System.out.println("Tong: " + sum);

		List<Integer> numbers = List.of(10, 5, 3, 12, 6, 7, 5, 3);
		Stream<Integer> streamList = numbers.stream();
		//1. Duyệt numbers
		streamList.forEach(i -> System.out.println(i));
		//2. Tìm các giá trị chẵn trong list
		List<Integer> evenNum = numbers.stream()
				.filter(i -> i%2 ==0)
				.toList();
		System.out.println(evenNum);
		//3. Tìm các giá trị > 5 trong list
		List<Integer> greaterFive = numbers.stream()
				.filter(i -> i>5)
				.toList();
		System.out.println(greaterFive);
		//4. Tìm giá trị max trong list
		Optional<Integer> max = numbers.stream()
				.max(Integer::compare);
		System.out.println(max);
		//5. Tìm giá trị min trong list
		Optional<Integer> min = numbers.stream()
				.min(Integer::compare);
		System.out.println(min);
		//6. Tính tổng các phần tử của mảng
		int sumNumber = numbers.stream()
				.mapToInt(Integer::intValue)
				.sum();
		System.out.println(sumNumber);
//		7. Lấy danh sách các phần tử không trùng nhau
		List<Integer> distinct = numbers.stream()
				.distinct()
				.toList();
		System.out.println(distinct);
//		8. Lấy 5 phần tử đầu tiên trong mảng
		List<Integer> firstFive = numbers.stream()
				.limit(5)
				.toList();
		System.out.println(firstFive);
//		9. Lấy phần tử từ thứ 3 -> thứ 5
		List<Integer> threeToFive = numbers.stream()
				.skip(2)
				.limit(3)
				.toList();
		System.out.println(threeToFive);
//		10. Lấy phần tử đầu tiên > 5
		Optional<Integer> firstGreaterFive = numbers.stream()
				.filter(i -> i>5)
				.findFirst();
		System.out.println(firstGreaterFive);
//		11. Kiểm tra xem list có phải là list chẵn hay không
		boolean isEven = numbers.stream()
				.allMatch(i -> i%2 == 0);
		System.out.println(isEven);
//		12. Kiểm tra xem list có phần tử > 10 hay không
		boolean isGreaterTen = numbers.stream()
				.anyMatch(i -> i>10);
		System.out.println(isGreaterTen);
//		13. Có bao nhiêu phần tử > 5
		long count = numbers.stream()
				.filter(i -> i>5)
				.count();
		System.out.println(count);
//		14. Nhân đôi các phần tủ trong list và trả về list mới
		List<Integer> listDouble = numbers.stream()
				.map(i -> i*2)
				.toList();
		System.out.println(listDouble);
//		15. Kiểm tra xem list không chứa giá trị nào = 8 hay không
		boolean isNotEight = numbers.stream()
				.noneMatch(i -> i == 8);
		System.out.println(isNotEight);
	}



}
