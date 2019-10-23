# destiny
原项目调整为微服务架构

原项目:https://github.com/1369521908/destiny-primary



服务结构

| 模块名                  | 服务名                  | 描述                | 模块类型     | IP/端口        | 备注                                       |
| :---------------------- | ----------------------- | ------------------- | ------------ | -------------- | ------------------------------------------ |
| destiny-eureka-server   | eureka-server           | eureka服务发现/注册 | 基础模块     | localhost/9527 |                                            |
| destiny-legends         | service-legends         | 核心模块            | 业务模块     | localhost/9531 |                                            |
| destiny-obsidian-client | service-obsidian-client | obsidian客户端      | 业务模块     | localhost/9532 |                                            |
| ObsidianCloud           | service-obsidian        | obsidian服务端      | 边缘业务模块 | localhost/9529 | https://github.com/1369521908/Obsidian.git |

