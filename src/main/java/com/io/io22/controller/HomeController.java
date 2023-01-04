package com.io.io22.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        model.addAttribute("products", getData());
        return "index";
    }

    public List<ProductModel> getData() {
        return List.of(
                getModel(0L, "LEGO Star Wars 75333", 159.99, 10D, "LEGO", "https://www.lego.com/pl-pl/product/obi-wan-kenobi-s-jedi-starfighter-75333"),
                getModel(1L, "LEGO Friends 41731 Międzynarodowa szkoła w Heartlake", 379.00, 10d, "al.to", "https://www.al.to/p/1091266-klocki-lego-lego-friends-41731-miedzynarodowa-szkola-w-heartlake.html"),
                getModel(2L, "Ikea Jattelik Pluszak 50471168", 84.90, 8d, "Allegro", "https://allegro.pl/oferta/ikea-jattelik-pluszak-dinozaur-stegozaur-75-cm-12694810478?ceneo_cid=b831eb4a-0be9-67fd-b89e-6a364ade3857"),
                getModel(3L, "Doris Karuzela pozytywka do łóżeczka projektor + pilot", 109.00, 15d, "Doris", "https://zabawkidoris.eu/pl/p/Karuzela-pozytywka-do-lozeczka-projektor-pilot/2339?ceneo_cid=997b88f6-183f-f295-4900-8ebde80cc35c"),
                getModel(4L, "Hasbro Figurka Iron Man Marvel Legends Ultron", 168.51, 0d, "Amazon", "https://www.amazon.pl/dp/B08P2178QM/?ceneo_cid=8dbbf0d3-7960-c05d-5657-a615b1ee05c1"),
                getModel(5L, "Cabrio M4 Czarny Autko Na Akumulator", 489.00, 15d, "Allegro", "https://allegro.pl/oferta/cabrio-m4-auto-na-akumulator-2-silniki-pilot-2-4g-9715242073?ceneo_cid=48dd8178-fe62-0eb4-d732-92d20bf3749d"),
                getModel(6L, "Hot Wheels Premium Team Transport Retro Rig 72 Plymouth Cuda FLF56 HCR40", 62.00, 5d, "Korob", "https://korob.pl/product-pol-401320-HOT-WHEELS-Team-Transport-Retro-Rig-72-Plymouth-Cuda-HCR40.html?ceneo_cid=f6420b82-d7a3-aab8-add3-333a6c68d3f6"),
                getModel(7L, "Revell Battleship Bismarck Mr-5098", 100.50, 20d, "3DJake", "https://www.3djake.pl/revell/battleship-bismarck?ceneo_cid=3f3e033c-e89a-df94-da93-af97bf41ddb8"),
                getModel(8L, "CARRERA RC Helikopter Orange Sply 501028", 146.90, 15d, "Kraina zabawy", "https://krainazabawy.pl/latajace/34698-carrera-rc-helikopter-orange-sply-ii-501028x-9003150116707.html?ceneo_cid=916815ad-acfe-8fdc-59fe-cf8eebd3112e"),
                getModel(9L, "Enero Toys Drewniana Kuchnia Dla Dzieci Światła Pizza", 109.00, 20d, "SKLEP TWOJEGO STAREGO", "https://allegro.pl/oferta/drewniana-kuchnia-dla-dzieci-akcesoria-oswietlenie-12916612438?ceneo_cid=2caa911f-2780-9ecd-777c-711008ea64bd")
        );
    }

    public ProductModel getModel(Long id, String name, Double price, Double shippingPrice, String seller, String link) {
        return ProductModel.builder()
                .id(id)
                .name(name)
                .price(price)
                .shippingPrice(shippingPrice)
                .seller(seller)
                .link(link)
                .build();
    }
}
