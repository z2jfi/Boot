package com.yefeng.boot_4.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.boot_4.pojo.Help;
import com.yefeng.boot_4.service.HelpService;
import com.yefeng.boot_4.DAO.HelpMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
* @author yefeng
* @description 针对表【t_help】的数据库操作Service实现
* @createDate 2023-06-01 11:35:11
*/
@Service
public class HelpServiceImpl extends ServiceImpl<HelpMapper, Help>
    implements HelpService{

    @Resource
    private HelpMapper helpMapper;

    @Override
    public List<Help> addLike(Help help) {
        Help byBidAndUid = helpMapper.selectAllByBidAndUid(help.getBid(), help.getUid());
        if (byBidAndUid == null){
            int selective = helpMapper.insertSelective(help);
            if (selective == 0){
                throw new RuntimeException("点赞失败！");
            }
        }else {
            int selective = helpMapper.updateSelective(help);
            if (selective == 0){
                throw new RuntimeException("点赞失败！");
            }
        }
        return helpMapper.searchAll();
    }

    @Override
    public List<Help> getLikes() {
        return helpMapper.searchAll();
    }

    @Override
    public List<Help> updatedHelp(Help help) {
        int updateSelective = helpMapper.updateSelective(help);
        if (updateSelective == 0){
            throw new RuntimeException("修改失败！");
        }
        List<Help> helpList = helpMapper.selectByUid(help.getUid());
        return helpList;
    }

    @Override
    public List<Help> getUserLikes(int uid) {
        return helpMapper.selectByUid(uid);
    }

    @Override
    public Integer getAllHelps(int uid) {
        Help helpByUid = helpMapper.selectAllHelpByUid(uid);
        if (helpByUid == null){
            return 0;
        }
        return helpByUid.getNum();
    }
}




