package com.lemon.util;

/**
 * CMS常量
 */
public class Constants {
	/**
	 * 首页模板
	 */
	public static final String TPLDIR_INDEX = "index";
	/**
	 * 栏目页模板
	 */
	public static final String TPLDIR_CHANNEL = "channel";
	/**
	 * 内容页模板
	 */
	public static final String TPLDIR_CONTENT = "content";
	/**
	 * 单页模板
	 */
	public static final String TPLDIR_ALONE = "alone";
	/**
	 * 专题模板
	 */
	public static final String TPLDIR_TOPIC = "topic";
	/**
	 * 会员中心模板
	 */
	public static final String TPLDIR_MEMBER = "member";
	/**
	 * hhc add 2014-08-03
	 * 用户中心
	 */
	public static final String TPLDIR_SPACE = "userspace";
	
	/**
	 * 专用模板
	 */
	public static final String TPLDIR_SPECIAL = "special";
	/**
	 * 可视化编辑模板
	 */
	public static final String TPLDIR_VISUAL = "visual";
	/**
	 * 公用模板
	 */
	public static final String TPLDIR_COMMON = "common";
	/**
	 * 客户端包含模板
	 */
	public static final String TPLDIR_CSI = "csi";
	/**
	 * 客户端包含用户自定义模板
	 */
	public static final String TPLDIR_CSI_CUSTOM = "csi_custom";
	/**
	 * 服务器端包含模板
	 */
	public static final String TPLDIR_SSI = "ssi";
	/**
	 * 标签模板
	 */
	public static final String TPLDIR_TAG = "tag";
	/**
	 * 评论模板
	 */
	public static final String TPLDIR_COMMENT = "comment";
	/**
	 * 留言模板
	 */
	public static final String TPLDIR_GUESTBOOK = "guestbook";
	/**
	 * 站内信模板
	 */
	public static final String TPLDIR_MESSAGE = "message";
	/**
	 * 列表样式模板
	 */
	public static final String TPLDIR_STYLE_LIST = "style_list";
	/**
	 * 列表样式模板
	 */
	public static final String TPLDIR_STYLE_PAGE = "style_page";

	/**
	 * 模板后缀
	 */
	public static final String TPL_SUFFIX = ".html";
	
	/**
	 * 前台方言
	 */
	public static final String LOCAL_FRONT = "zh_CN";

	/**
	 * 上传路径
	 */
	public static final String UPLOAD_PATH = "/u/cms/";
	
	/**
	 * 用户发布原创事，上传图片的路径
	 */
	public static final String USER_UPLOAD_PATH = "/u/user/";
	/**
	 * 截图路径
	 */
	public static final String SNAP_PATH = "/u/cms/snap";
	/**
	 * 上传路径
	 */
	public static final String LIBRARY_PATH = "/wenku/";
	/**
	 * 文库上传文件后缀
	 */
	public static final String LIBRARY_SUFFIX = "odt,txt,pdf,wps,et,dps,vsd,pot,pps,rtf,doc,docx,xls,xlsx,ppt,pptx";
	/**
	 * 资源路径
	 */
	public static final String RES_PATH = "/r/cms";
	/**
	 * 模板路径
	 */
	public static final String TPL_BASE = "/WEB-INF/t/cms";
	/**
	 * 全文检索索引路径
	 */
	public static final String LUCENE_PATH = "/WEB-INF/lucene";
	/**
	 * 列表样式模板路径
	 */
	public static final String TPL_STYLE_LIST = "/WEB-INF/t/cms_sys_defined/style_list/style_";
	/**
	 * 内容分页模板路径
	 */
	public static final String TPL_STYLE_PAGE_CONTENT = "/WEB-INF/t/cms_sys_defined/style_page/content_";
	/**
	 * 列表分页模板路径
	 */
	public static final String TPL_STYLE_PAGE_CHANNEL = "/WEB-INF/t/cms_sys_defined/style_page/channel_";
	/**
	 * 页面禁止访问
	 */
	public static final String ERROR_403 = "error/403";
	/**
	 * 数据库备份路径
	 */
	public static final String BACKUP_PATH = "/WEB-INF/backup";
	/**
	 * 数据库备份文本前缀
	 */
	public static String ONESQL_PREFIX="JEECMS_BACKUP_";
	/**
	 * 防火墙配置文件
	 */
	public static String FIREWALL_CONFIGPATH = "/WEB-INF/config/firewall.properties";
	/**
	 * 类--错误国际化信息配置
	 */
	public static String CLASS_ERROR_CODE = "/WEB-INF/config/classes-error.properties";
	/**
	 * 配置文件
	 */
	public static String JEECMS_CONFIG = "/WEB-INF/config/jeecms/jeecms.properties";
	/**
	 * 插件路径
	 */
	public static final String PLUG_PATH = "/WEB-INF/plug/";
	/**
	 * 标签模板路径
	 */
	public static final String DIRECTIVE_TPL_PATH = "/WEB-INF/directive/";
	/**
	 * 后台资源路径
	 */
	public static final String RES_BACK_PATH = "/res";
	/**
	 * 模板路径
	 */
	public static final String TPL_BACK_BASE = "/WEB-INF/jeecms_sys";
	
	/**
	 * 基于机构 从新设置的模板* TB_COMPANY *
	 */
	public static final String  TB_COMPANY_COUNT= "af/company";
	/**
	 *产品 从新设置的模板* TB_PRODUCT *
	 */
	public static final String  TB_PRODUCT= "af/product";
	
	/**
	 * 亚洲财经支付模板
	 */
	public static final String AF_PAY = "af/pay";
	/**
	 *用户设置模板* TB_USERSET *
	 */
	public static final String  TB_USERSET= "af/userspace";
	/**
	 * hhc add 2014-08-11
	 * 共建平台
	 */
	public static final String WEPLATFORM = "af/weplatform";
	
	/**
	 * 支付系统 配置文件
	 */
	public static String AF_PAY_CONFIG = "/WEB-INF/config/plug/af/af-pay-config.properties";
}
