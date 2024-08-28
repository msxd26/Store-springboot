package pe.jsaire.store.web.app.infraestructures.abstract_services;

public interface GenericService <RS,RQ,ID> {

    RS findById(ID id);
    RS save(RQ rq);
    RS update(RQ rq, ID id);
    void deleteById(ID id);
}
