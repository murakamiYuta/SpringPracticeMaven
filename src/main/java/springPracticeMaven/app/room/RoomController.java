package springPracticeMaven.app.room;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import springPracticeMaven.domin.model.ReservableRoom;
import springPracticeMaven.domin.service.room.RoomService;

@Controller
@RequestMapping("rooms")
@AllArgsConstructor
public class RoomController {

	RoomService roomService;

	@GetMapping
	String listRooms(Model model) {
		LocalDate today = LocalDate.now();
		List<ReservableRoom> rooms = roomService.findReservableRooms(today);
		model.addAttribute("date", today);
		model.addAttribute("rooms", rooms);
		return "room/listRooms";
	}
}
