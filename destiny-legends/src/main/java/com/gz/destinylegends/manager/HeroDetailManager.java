package com.gz.destinylegends.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gz.destinylegends.constant.Constant;
import com.gz.destinylegends.entity.HeroDetail;
import com.gz.destinylegends.mapper.HeroDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Destiny_Xue
 * @Date 2019/9/27 23:52
 * @Description
 */
@Service
public class HeroDetailManager {

    @Autowired
    private HeroDetailMapper heroDetailMapper;

    /**
     * 英雄六芒星属性
     *
     * @param heroId 英雄id
     * @return 结果列表, index 0:目标英雄; index final: 平均值;
     */
    public List<HeroDetail> hexagram(Long heroId) {

        // 第一个是目标英雄,第二个是平均值
        LinkedList<HeroDetail> heroDetails = new LinkedList<>();

        QueryWrapper<HeroDetail> wrapper = new QueryWrapper<>();
        List<HeroDetail> detailList = heroDetailMapper.selectList(wrapper);

        // 设置平均值用
        HeroDetail avgDetail = new HeroDetail();

        // 物理攻击
        BigDecimal attackTotal = new BigDecimal(0);
        // 防御
        BigDecimal defenseTotal = new BigDecimal(0);
        // 魔法
        BigDecimal magicTotal = new BigDecimal(0);
        // 上手难度
        BigDecimal difficultyTotal = new BigDecimal(0);
        // 英雄难度等级
        BigDecimal difficultyLevelTotal = new BigDecimal(0);
        // 伤害
        BigDecimal damageTotal = new BigDecimal(0);
        // 坦克倾向(偏向坦克程度)
        BigDecimal durabilityTotal = new BigDecimal(0);
        // 团控
        BigDecimal crowdControlTotal = new BigDecimal(0);
        // 机动性
        BigDecimal mobilityTotal = new BigDecimal(0);
        // 功能性
        BigDecimal utilityTotal = new BigDecimal(0);

        // 英雄数量
        BigDecimal heroNum = new BigDecimal(detailList.size());

        for (HeroDetail detail : detailList) {
            if (detail.getHeroId().equals(heroId)) {
                heroDetails.add(detail);
            }
            attackTotal = new BigDecimal(detail.getAttack()).add(attackTotal);
            defenseTotal = new BigDecimal(detail.getDefense()).add(defenseTotal);
            magicTotal = new BigDecimal(detail.getMagic()).add(magicTotal);
            difficultyTotal = new BigDecimal(detail.getDifficulty()).add(difficultyTotal);
            damageTotal = new BigDecimal(detail.getDamage()).add(damageTotal);
            durabilityTotal = new BigDecimal(detail.getDurability()).add(durabilityTotal);
            crowdControlTotal = new BigDecimal(detail.getCrowdControl()).add(crowdControlTotal);
            mobilityTotal = new BigDecimal(detail.getMobility()).add(mobilityTotal);
            utilityTotal = new BigDecimal(detail.getUtility()).add(utilityTotal);
            difficultyLevelTotal = new BigDecimal(detail.getDifficultyL()).add(difficultyLevelTotal);
        }

        // 设置平均值
        avgDetail.setAttack(attackTotal.divide(heroNum, Constant.SCALE, Constant.ROUNDING_MODE).intValue());
        avgDetail.setDefense(defenseTotal.divide(heroNum, Constant.SCALE, Constant.ROUNDING_MODE).intValue());
        avgDetail.setMagic(magicTotal.divide(heroNum, Constant.SCALE, Constant.ROUNDING_MODE).intValue());
        avgDetail.setDifficulty(difficultyTotal.divide(heroNum, Constant.SCALE, Constant.ROUNDING_MODE).intValue());
        avgDetail.setDamage(damageTotal.divide(heroNum, Constant.SCALE, Constant.ROUNDING_MODE).intValue());
        avgDetail.setDurability(durabilityTotal.divide(heroNum, Constant.SCALE, Constant.ROUNDING_MODE).intValue());
        avgDetail.setCrowdControl(crowdControlTotal.divide(heroNum, Constant.SCALE, Constant.ROUNDING_MODE).intValue());
        avgDetail.setCrowdControl(mobilityTotal.divide(heroNum, Constant.SCALE, Constant.ROUNDING_MODE).intValue());
        avgDetail.setUtility(utilityTotal.divide(heroNum, Constant.SCALE, Constant.ROUNDING_MODE).intValue());
        avgDetail.setDifficultyL(difficultyLevelTotal.divide(heroNum, Constant.SCALE, Constant.ROUNDING_MODE).intValue());

        heroDetails.add(avgDetail);
        return heroDetails;
    }

}
