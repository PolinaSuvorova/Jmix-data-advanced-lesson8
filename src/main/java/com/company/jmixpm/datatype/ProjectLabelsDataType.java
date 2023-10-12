package com.company.jmixpm.datatype;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import io.jmix.core.metamodel.annotation.DatatypeDef;
import io.jmix.core.metamodel.annotation.Ddl;
import io.jmix.core.metamodel.datatype.Datatype;

import javax.annotation.Nullable;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

//@Convert( converter = ProjectLablesConverter.class)
@DatatypeDef(id = "projectlabels", javaClass = ProjectLabels.class)
@Ddl("varchar(500)")
public class ProjectLabelsDataType implements Datatype<ProjectLabels> {

    @Override
    public String format(@Nullable Object value) {
        if (value != null && value instanceof ProjectLabels) {
            return Joiner.on(", ")
                    .join(((ProjectLabels) value).getLabels());
        }
        return "";
    }

    @Override
    public String format(@Nullable Object value, Locale locale) {
        return format(value);
    }

    @Nullable
    @Override
    public ProjectLabels parse(@Nullable String value) throws ParseException {
        if (value != null) {
            List<String> list = Splitter.on(", ")
                    .splitToList((String) value);
            return new ProjectLabels(list);
        }
        return null;
    }

    @Nullable
    @Override
    public ProjectLabels parse(@Nullable String value, Locale locale) throws ParseException {
        return parse(value);
    }
}
