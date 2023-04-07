<?php
namespace App\Repository;

use App\Entity\Reclamation;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Reclamation|null find($id, $lockMode = null, $lockVersion = null)
 * @method Reclamation|null findOneBy(array $criteria, array $orderBy = null)
 * @method Reclamation[]    findAll()
 * @method Reclamation[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class ReclamationRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Reclamation::class);
    }

    public function create(Reclamation $reclamation): void
    {
        $this->_em->persist($reclamation);
        $this->_em->flush();
    }

    public function read(int $id): ?Reclamation
    {
        return $this->find($id);
    }

    public function update(Reclamation $reclamation): void
    {
        $this->_em->flush();
    }

    public function delete(Reclamation $reclamation): void
    {
        $this->_em->remove($reclamation);
        $this->_em->flush();
    }

    public function getOpenReclamations(): ?array
    {
        $qb = $this->createQueryBuilder('r');
        $qb->where('r.status = :status');
        $qb->setParameter('status', 'open');
        return $qb->getQuery()->getResult();
    }
}