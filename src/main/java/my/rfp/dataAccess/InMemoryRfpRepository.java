package my.rfp.dataAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import my.rfp.dataAccess.abstracts.RfpRepository;
import my.rfp.entities.rfpMain.Rfp;

public class InMemoryRfpRepository implements RfpRepository{

	List<Rfp> rfps;
private final RfpRepository rfpRepository3 = null;

	
//	içi boş constructor
	 public InMemoryRfpRepository() {
		 rfps = new ArrayList<Rfp>();
		Rfp rfps=new Rfp();
//
//		rfps.setAd("büşraaaa");
//		rfps.setSoyadi("pacci");
//		
//		rfpRepository.save(rfps);
		
//		
//		rfps.setId(3);
//		rfps.setLevel_of_coverage("R");
		
		rfpRepository3.save(rfps);
		
//		rfps.add(new Rfp(1,"gggg", "kkkk", "kkkk","kkkk", "rrffffg"));
//		rfps.add(new Rfp(2,"gggg", "kkkk", "kkkk","kkkk", "rrffffg"));
//		rfps.add(new Rfp(3,"gggg", "kkkk", "kkkk","kkkk", "rrffffg"));
//		rfps.add(new Rfp(4,"gggg", "kkkk", "kkkk","kkkk", "rrffffg"));

	}		
	
	
	
	
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Rfp> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Rfp> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Rfp> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rfp getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rfp getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rfp getReferenceById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Rfp> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Rfp> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Rfp> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rfp> findAll() {
	    return new ArrayList<>(rfps);
	}


	@Override
	public List<Rfp> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Rfp> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Rfp> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Rfp entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Rfp> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Rfp> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Rfp> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Rfp> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Rfp> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Rfp> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Rfp> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Rfp, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

}
