CREATE DATABASE IF NOT EXISTS `sad_cloud_shop` DEFAULT CHARACTER SET utf8;

-- authorities for mannaya_kasha
GRANT CREATE, SELECT, INSERT, UPDATE, DELETE, ALTER
ON `sad_cloud_shop`.*
TO mannaya_kasha@localhost
IDENTIFIED BY 'mannaya_kasha_password';

GRANT CREATE, SELECT, INSERT, UPDATE, DELETE, ALTER
ON `sad_cloud_shop`.*
TO mannaya_kasha@'%'
IDENTIFIED BY 'mannaya_kasha_password';