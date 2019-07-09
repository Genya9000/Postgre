package ml.trucking.tag;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
public class DateTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        try {
            Date currentDate = new Date();
            SimpleDateFormat dateFormat = null;
            dateFormat = new SimpleDateFormat("EEEE dd MMMM");
            pageContext.getOut().print(dateFormat.format( currentDate ));
        } catch (IOException ex) {
            throw new JspException(ex.getMessage());
        }
        return SKIP_BODY;
    }
}