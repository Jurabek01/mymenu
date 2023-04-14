package mimsoft.io.lemenu.branch;

import java.util.List;

public interface BranchService {

    List<BranchDto> getAll();

    BranchDto get(Long id);
    boolean save(BranchDto branchDto);
    boolean update(BranchDto branchDto);
    boolean delete(Long id);
}
