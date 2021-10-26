package pe.store.repository;

import org.springframework.stereotype.Repository;
import pe.store.model.Area;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Repository
public class AreaRepositoryImpl {

    private static Collection<Area> itemsArea = new ArrayList<>();

    @PostConstruct // ? le estas diciendo al ctx Spring IoC que automaticamente ejecute este metodo
    // post instanciacion.
    public void initData() {
        Area area1 = new Area(1, "Venta","A");
        Area area2 = new Area(2, "Produccion", "A");
        itemsArea.add(area1);
        itemsArea.add(area2);
    }


    public void insert(Area area) {
        // TODO Auto-generated method stub
        itemsArea.add(area);
    }


    public void update(Area area) {
        // TODO Auto-generated method stub
        // ubico el actual
        Area oldArea = findById(area.getAreaId());
        // borrar el actual de la lista
        itemsArea.remove(oldArea);
        // crear el nuevo en la lista
        itemsArea.add(area);
    }


    public void delete(Integer areaId) {
        // TODO Auto-generated method stub
        // ubico el actual
        Area oldArea = findById(areaId);
        // borrar el actual de la lista
        itemsArea.remove(oldArea);
    }


    public Area findById(Integer areaId) {
        // TODO Auto-generated method stub
        Optional<Area> area = itemsArea.stream().filter(p -> p.getAreaId() == areaId)
                .findFirst();
        return area.orElse(null);
    }


    public Collection<Area> findAll() {
        return itemsArea;
    }
}
