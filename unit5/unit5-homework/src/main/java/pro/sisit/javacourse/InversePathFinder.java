package pro.sisit.javacourse;

import pro.sisit.javacourse.inverse.BigDecimalRange;
import pro.sisit.javacourse.inverse.InverseDeliveryTask;
import pro.sisit.javacourse.inverse.Solution;
import pro.sisit.javacourse.optimal.DeliveryTask;
import pro.sisit.javacourse.optimal.Route;
import pro.sisit.javacourse.optimal.Transport;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class InversePathFinder {

    /**
     * Принимает на вход InverseDeliveryTask task - обратную задачу доставки груза.
     * Мы должны по переданному в ней списку возможных задач, списку доступного транспорта,
     * а также диапазону цены определить что за задачи доставки груза могли быть решены.
     * Возвращает список решений задачи доставки груза (Solution),
     * удовлетворяющий параметру переданному параметру task:
     * 1. Транспорт должен быть доступен для решения данной задачи
     * 2. Стоимость решения задачи должна входить в диапазон цены пераметра task
     * 3. Также возвращаемый список должен быть осортирован по двум значениям:
     * - сначала по итоговой стоимости решения задачи - по убыванию
     * - затем, если цены одинаковы - по наименованию задачи доставки по алфавиту - по возрастанию
     * Если task равна null, то функция должна вернуть пустой список доступных решений.
     * Если внутри параметра task данные по возможным задачам, доступному транспорту либо по итоговой цене равны null,
     * то функция должна вернуть пустой список доступных решений.
     */
    public List<Solution> getAllSolutions(InverseDeliveryTask task) {
        // ToDo: realize me!
        return new ArrayList<>();
    }
}