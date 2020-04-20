package com.lucky.luckinstore.controller;

import com.lucky.luckinstore.pojo.ao.CommentAO;
import com.lucky.luckinstore.pojo.dto.CommentDTO;
import com.lucky.luckinstore.service.CommentService;
import com.lucky.luckinstore.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 张成
 * @date: Create in 2019/10/12
 * @description:
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    //日志
    private final static Logger logger = LoggerFactory.getLogger(CommentController.class);

    /**
     * @description 增加评论的接口
     * @author 张成
     * @date 2019/10/12 9:49
     * @param
     * @return
     */
    @PostMapping("/addComment")
    public Result<Integer> addComment(@RequestBody CommentAO commentAO) {
        logger.info("commentAO: " + commentAO.toString());
        CommentDTO commentDTO = new CommentDTO();
        BeanUtils.copyProperties(commentAO, commentDTO);
        return commentService.insertComment(commentDTO);
    }
}
