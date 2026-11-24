package cl.duoc.mastermartini_api.config;

import cl.duoc.mastermartini_api.model.ContenidoEntity;
import cl.duoc.mastermartini_api.repository.ContenidoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner precargarDatosMySQL(ContenidoRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.saveAll(List.of(
                        new ContenidoEntity(
                                "Bombones Templados con Chocolate Ariba",
                                "Receta",
                                "Chocolatería",
                                "Chocolate Ariba Oscuro 54% Master Martini",
                                "45 min",
                                "1. Fundir el chocolate Ariba a 45°C.\n2. Descender temperatura en mármol a 28°C y subir a 31°C.\n3. Moldear casquillos, rellenar con ganache y sellar.",
                                null
                        ),
                        new ContenidoEntity(
                                "Curso Especialidad: Masas de Hoja y Croissant",
                                "Curso",
                                "Masas de hoja",
                                "Margarina de Hoja Gioia Placa Master Martini",
                                "4 horas",
                                "Módulo 1: Amasado y reposo en frío.\nMódulo 2: Empaste con Margarina Gioia y 3 vueltas simples.\nMódulo 3: Fermentación controlada y horneo a 190°C.",
                                null
                        ),
                        new ContenidoEntity(
                                "Técnica de Montado de Crema Vegetal en Vitrina",
                                "Video Técnico",
                                "Pastelería de vitrina",
                                "Crema Vegetal Decor Up Master Martini",
                                "15 min",
                                "1. Enfriar Crema Decor Up entre 4°C y 6°C por 12 horas.\n2. Batir a velocidad media hasta punto firme.\n3. Aplicar con boquilla rizada para decoración estable en vitrina.",
                                null
                        ),
                        new ContenidoEntity(
                                "Helado Artesanal de Pistacho y Fior di Latte",
                                "Receta",
                                "Heladería",
                                "Base Láctea y Pasta Concentrada Master Martini",
                                "60 min",
                                "1. Mezclar base neutra con leche tibia.\n2. Incorporar pasta de pistacho y madurar por 4 horas.\n3. Mantecar y abatir a -18°C.",
                                null
                        )
                ));
            }
        };
    }
}