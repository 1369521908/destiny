package com.gz.destinylegends.config.shiro;

public class ShiroPermission {

    //**********通用定义 start**********

    /**
     * 分隔符
     */
    private final static String SIGN = ":";
    /**
     * 保存权限
     */
    private final static String SAVE = SIGN + "save";
    /**
     * 删除权限
     */
    private final static String DELETE = SIGN + "delete";
    /**
     * 浏览权限
     */
    private final static String VIEW = SIGN + "view";
    /**
     * 爬取数据权限
     */
    private final static String WORN = SIGN + "worn";

    //**********通用定义 end**********


    //**********接口权限定义 start**********

    //**********com.gz.destiny.controller.user.UserController start**********
    /**
     * 用户保存
     */
    public final static String USER_SAVE = "user" + SAVE;
    /**
     * 用户删除
     */
    public final static String USER_DELETE = "user" + DELETE;
    /**
     * 用户浏览
     */
    public final static String USER_VIEW = "user" + VIEW;
    //**********com.gz.destiny.controller.user.UserController end**********

    //**********com.gz.destiny.controller.lol.hero.HeroController start**********
    /**
     * 英雄保存
     */
    public final static String HERO_SAVE = "hero" + SAVE;
    /**
     * 英雄删除
     */
    public final static String HERO_DELETE = "hero" + DELETE;
    /**
     * 英雄浏览
     */
    public final static String HERO_VIEW = "hero" + VIEW;
    /**
     * 英雄数据爬取
     */
    public static final String HERO_WORN = "hero" + WORN;
    //**********com.gz.destiny.controller.lol.hero.HeroController end**********

    //**********com.gz.destiny.controller.lol.hero.HeroDetailController start**********
    /**
     * 英雄明细保存
     */
    public final static String HERO_DETAIL_SAVE = "heroDetail" + SAVE;
    /**
     * 英雄明细删除
     */
    public final static String HERO_DETAIL_DELETE = "heroDetail" + DELETE;
    /**
     * 英雄明细浏览
     */
    public final static String HERO_DETAIL_VIEW = "heroDetail" + VIEW;
    //**********com.gz.destiny.controller.lol.hero.HeroDetailController start**********

    //**********com.gz.destiny.controller.lol.item.ItemController start**********
    /**
     * 物品保存
     */
    public final static String ITEM_SAVE = "item" + SAVE;
    /**
     * 物品删除
     */
    public final static String ITEM_DELETE = "item" + DELETE;
    /**
     * 物品浏览
     */
    public final static String ITEM_VIEW = "item" + VIEW;
    /**
     * 物品数据爬取
     */
    public final static String ITEM_WORN = "item" + WORN;
    //**********com.gz.destiny.controller.lol.item.ItemController end**********

    //**********com.gz.destiny.controller.lol.runes.RunesController start**********
    /**
     * 符文保存
     */
    public final static String RUNES_SAVE = "runes" + SAVE;
    /**
     * 符文删除
     */
    public final static String RUNES_DELETE = "runes" + DELETE;
    /**
     * 符文浏览
     */
    public final static String RUNES_VIEW = "runes" + VIEW;
    /**
     * 符文数据爬取
     */
    public final static String RUNES_WORN = "runes" + WORN;
    //**********com.gz.destiny.controller.lol.runes.RunesController end**********

    //**********com.gz.destiny.controller.lol.summoner.SummonerSkillController start**********
    /**
     * 召唤师技能保存
     */
    public final static String SUMMONER_SKILL_SAVE = "summonerSkill" + SAVE;
    /**
     * 召唤师技能删除
     */
    public final static String SUMMONER_SKILL_DELETE = "summonerSkill" + DELETE;
    /**
     * 召唤师技能浏览
     */
    public final static String SUMMONER_SKILL_VIEW = "summonerSkill" + VIEW;
    /**
     * 召唤师技能数据爬取
     */
    public final static String SUMMONER_SKILL_WORN = "summonerSkill" + WORN;
    //**********com.gz.destiny.controller.lol.summoner.SummonerSkillController end**********

    //**********接口权限定义 end**********
}
