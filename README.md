# Coca

> - 名称源自阿里的cola，将自己经常用到的小组件封装、开源
> - coca-starter [基于coca封装spring常用模块]

## 组成

- coca-dependencies: 定义了所有依赖版本，方便项目后续引用
- coca-bom: 管理所有模块（版本），使用coca只需引入它即可
- coca-base: 定义最基础的枚举类、常量类等（无任何外部依赖）
- coca-dto: 定义常用的DTO，如文件上传下载、前端结果封装
- coca-exception: 定义了一些常见异常，如：系统异常、业务异常、第三方异常、用户异常等
- coca-jackson: 对jackson常用设置封装，具体配置见`cn.luis.coca.jackson.config.SimpleModuleConfig`
- coca-log: slf4j配合logback所需的依赖封装
- coca-util: 常用工具类