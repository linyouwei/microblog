package org.uclbrt.dao;
import java.util.List;
import java.util.Map;

import org.uclbrt.entity.Comment;
import org.uclbrt.entity.Daily;

public interface CommentMapper {
	List<Comment> getCommentByDailyId(int dailyId);
}
