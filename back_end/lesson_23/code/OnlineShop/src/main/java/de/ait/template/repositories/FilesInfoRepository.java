package de.ait.template.repositories;

import de.ait.template.models.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesInfoRepository extends JpaRepository<FileInfo, Long> {
}
