package pl.dopierala.SpringCourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;
import pl.dopierala.SpringCourse.domain.Quest;
import pl.dopierala.SpringCourse.domain.repository.QuestRepository;

import java.text.ParseException;
import java.util.Locale;

@Service
public class QuestFormater implements Formatter<Quest> {

    @Autowired
    QuestRepository questRepository;

    @Override
    public Quest parse(String idAsStr, Locale locale) throws ParseException {
        Integer id = Integer.parseInt(idAsStr);
        return questRepository.getQuest(id);
    }

    @Override
    public String print(Quest object, Locale locale) {
        return object.toString();
    }
}
