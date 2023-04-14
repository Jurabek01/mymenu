package mimsoft.io.lemenu.branch;

import mimsoft.io.lemenu.content.TextModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public List<BranchDto> getAll() {
        return branchRepository.findAllByDeletedFalse().stream()
                .map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public BranchDto get(Long id) {
        Branch branch = branchRepository.findByIdAndByDeletedFalse(id);
        if (branch == null)
            return null;
        return toDto(branch);
    }

    @Override
    public boolean save(BranchDto branchDto) {
        branchRepository.save(fromDto(branchDto));
        return true;
    }

    @Override
    public boolean update(BranchDto branchDto) {
        if (branchRepository.findByIdAndByDeletedFalse(branchDto.getId()) != null) {
            branchRepository.save(fromDto(branchDto));
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        Branch branchOptional = branchRepository.findByIdAndByDeletedFalse(id);
        if (branchOptional!=null){
            branchOptional.setDeleted(true);
            branchRepository.save(branchOptional);
        }
        return false;
    }

    private Branch fromDto(BranchDto branchDto) {
        return Branch.builder()
                .id(branchDto.getId())
                .nameUz(branchDto.getName().getUz())
                .nameRu(branchDto.getName().getRu())
                .nameEng(branchDto.getName().getEng())
                .longitude(branchDto.getLongitude())
                .latitude(branchDto.getLatitude())
                .address(branchDto.getAddress())
                .build();
    }

    private BranchDto toDto(Branch branch) {
        return BranchDto.builder()
                .id(branch.getId())
                .name(
                        new TextModel(
                                branch.getNameUz(),
                                branch.getNameRu(),
                                branch.getNameEng()
                        )
                )
                .longitude(branch.getLongitude())
                .latitude(branch.getLatitude())
                .address(branch.getAddress())
                .build();
    }
}
