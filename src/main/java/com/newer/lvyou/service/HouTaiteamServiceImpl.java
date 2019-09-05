package com.newer.lvyou.service;

import com.newer.lvyou.domain.tuandui;
import com.newer.lvyou.mapper.HouTaiTeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouTaiteamServiceImpl implements HouTaiteamService{

    @Autowired
    private HouTaiTeamMapper houTaiTeamMapper;

    /**
     * 显示所有团队以及信息
     * @return
     */
    @Override
    public List<tuandui> findAllTuandui() {
        return houTaiTeamMapper.findAllTuandui();
    }

    /**
     * 根据团队姓名进行分页显示
     * @param tname
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public List<tuandui> findAllTuanDuiFenYe(String tname, Integer pageNo, Integer pageSize) {
        return houTaiTeamMapper.findAllTuanDuiFenYe(tname,pageNo,pageSize);
    }

    /**
     * 新增用户信息
     * @param tuandui
     * @return
     */
    @Override
    public int tuanduiAdd(tuandui tuandui) {
        return houTaiTeamMapper.tuanduiAdd(tuandui);
    }

    /**
     * 根据团队id删除团队信息
     * @param id
     * @return
     */
    @Override
    public int tuanduiDelete(Integer id) {
        return houTaiTeamMapper.tuanduiDelete(id);
    }

    /**
     * 修改单个团队信息
     * @param tuandui
     * @return
     */
    @Override
    public int userUpdate(tuandui tuandui) {
        return houTaiTeamMapper.tuanduiUpdate(tuandui);
    }

    /**
     * 统计团队总数量
     * @param tname
     * @return
     */
    @Override
    public int tuanduiCount(String tname) {
        return houTaiTeamMapper.tuanduiCount(tname);
    }

    /**
     * 根据id查询单个团队信息
     * @param id
     * @return
     */
    @Override
    public tuandui findOneTuandui(Integer id) {
        return houTaiTeamMapper.findOneTuandui(id);
    }
}
